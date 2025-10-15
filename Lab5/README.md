# Lab 5: HTTP Server with Pub-Sub Pattern using Flask

This is a Flask-based HTTP server implementing a publish-subscribe pattern. The server maintains a list of subscribers and allows publishing updates to all subscribers.

## Requirements

- Python 3.x
- Flask

## Installation

Install Flask if you haven't already:

```bash
pip install flask
```

## Running the Server

1. Start the server:
```bash
python flaskHttpServer.py
```
The server will run on `http://localhost:5000`

## Testing the Endpoints

Open a new terminal and use curl to test the endpoints:

1. Add a subscriber:
```bash
curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"Alice\",\"URI\":\"http://site.com\"}" http://localhost:5000/add-subscriber
```

2. List all subscribers:
```bash
curl http://localhost:5000/list-subscribers
```

3. Delete a subscriber:
```bash
curl -X DELETE -H "Content-Type: application/json" -d "{\"name\":\"Alice\"}" http://localhost:5000/delete-subscriber
```

4. Update subject and notify subscribers:
```bash
curl -X POST -H "Content-Type: application/json" -d "{\"subject-update\":\"New Update\"}" http://localhost:5000/update-and-notify
```

## API Endpoints

- `GET /list-subscribers`: Returns list of all subscribers
- `POST /add-subscriber`: Add new subscriber (requires name and URI)
- `DELETE /delete-subscriber`: Remove subscriber by name
- `POST /update-and-notify`: Update subject and notify all subscribers

## Running Unit Tests

The server comes with a basic Unittest that verifies all endpoints and functionality. To run the tests:

1. Make sure you're in the project directory
2. Run the following command:
```bash
python -m unittest ServerUnittests.py
```

The tests will verify:
- Root endpoint functionality
- Adding and listing subscribers
- Deleting subscribers
- Update and notify functionality

Note: The server does not need to be running to execute the unit tests.