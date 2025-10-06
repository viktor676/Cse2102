import unittest
from my_server import app, get_prime_factors

class TestFactorsEndpoint(unittest.TestCase):
    def setUp(self):
        self.app = app.test_client()
        self.app.testing = True

    def test_get_prime_factors(self):
        # Test prime number
        self.assertEqual(get_prime_factors(17), [17])
        
        # Test composite number
        self.assertEqual(get_prime_factors(12), [2, 2, 3])
        
        # Test number 1
        self.assertEqual(get_prime_factors(1), [1])
        
        # Test larger composite number
        self.assertEqual(get_prime_factors(100), [2, 2, 5, 5])

    def test_factors_endpoint(self):
        # Test prime number
        response = self.app.get('/factors/17')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json, [17])
        
        # Test composite number
        response = self.app.get('/factors/12')
        self.assertEqual(response.status_code, 200)
        self.assertEqual(response.json, [2, 2, 3])
        
        # Test invalid input
        response = self.app.get('/factors/-1')
        self.assertEqual(response.status_code, 400)

if __name__ == '__main__':
    unittest.main()
