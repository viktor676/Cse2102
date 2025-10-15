import unittest
import json
from flaskHttpServer import app

class FlaskServerTests(unittest.TestCase):
    def setUp(self):
        # Create a test client
        self.client = app.test_client()
        # Propagate exceptions
        self.client.testing = True 

    def test_root_endpoint(self):
        # Test the root endpoint
        response = self.client.get('/')
        data = json.loads(response.data)
        self.assertEqual(response.status_code, 200)
        self.assertEqual(data['main endpoint'], 'Ack')

    def test_add_and_list_subscribers(self):
        # Test adding a subscriber
        subscriber_data = {
            'name': 'TestUser',
            'URI': 'http://test.com'
        }
        response = self.client.post('/add-subscriber',
                                  data=json.dumps(subscriber_data),
                                  content_type='application/json')
        self.assertEqual(response.status_code, 200)
        
        # Test listing subscribers
        response = self.client.get('/list-subscribers')
        data = json.loads(response.data)
        self.assertEqual(response.status_code, 200)
        self.assertIn('TestUser', data)
        self.assertEqual(data['TestUser'], 'http://test.com')

    def test_delete_subscriber(self):
        # First add a subscriber
        subscriber_data = {
            'name': 'UserToDelete',
            'URI': 'http://delete.com'
        }
        self.client.post('/add-subscriber',
                        data=json.dumps(subscriber_data),
                        content_type='application/json')
        
        # Test deleting the subscriber
        delete_data = {'name': 'UserToDelete'}
        response = self.client.delete('/delete-subscriber',
                                    data=json.dumps(delete_data),
                                    content_type='application/json')
        self.assertEqual(response.status_code, 200)
        
        # Verify subscriber was deleted
        response = self.client.get('/list-subscribers')
        data = json.loads(response.data)
        self.assertNotIn('UserToDelete', data)

    def test_update_and_notify(self):
        # First add a subscriber
        subscriber_data = {
            'name': 'NotifyUser',
            'URI': 'http://notify.com'
        }
        self.client.post('/add-subscriber',
                        data=json.dumps(subscriber_data),
                        content_type='application/json')
        
        # Test update and notify
        update_data = {'subject-update': 'Test Update'}
        response = self.client.post('/update-and-notify',
                                  data=json.dumps(update_data),
                                  content_type='application/json')
        self.assertEqual(response.status_code, 200)
        data = json.loads(response.data)
        self.assertIn('Test Update', data['message'])

if __name__ == '__main__':
    unittest.main()
