import httpx

url = "https://reimagined-space-fortnight-v5v6554rqvj24px-5000.app.github.dev/"

# Test the root endpoint
response = httpx.get(url)
print("Testing root endpoint:")
print(f"Status code: {response.status_code}")
print(f"Response: {response.text}\n")

# Test the echo endpoint
mydata = {
    "text": "Hello Viktor!",
    "param2": "Making a POST request",
    "body": "my own value"
}

response = httpx.post(url + "echo", data=mydata)
print("Testing echo endpoint:")
print(f"Status code: {response.status_code}")
print(f"Response: {response.text}\n")

# Test the factors endpoint with different numbers
test_numbers = [12, 17, 100]
for number in test_numbers:
    response = httpx.get(url + f"factors/{number}")
    print(f"Testing factors endpoint with {number}:")
    print(f"Status code: {response.status_code}")
    print(f"Prime factors: {response.text}\n") 