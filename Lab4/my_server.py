from flask import Flask, request, jsonify

app = Flask(__name__)

def get_prime_factors(n):
    factors = []
    d = 2
    while n > 1:
        while n % d == 0:
            factors.append(d)
            n //= d
        d += 1
        if d * d > n:
            if n > 1:
                factors.append(n)
            break
    return factors if len(factors) > 0 else [n]

@app.route("/")
def hello():
    return " you called \n"

# curl -d "text=Hello!&param2=value2" -X POST http://localhost:5000/echo
@app.route("/echo", methods=['POST'])
def echo():
    return "You said: " + request.form['text']

@app.route("/factors/<number>", methods=['GET'])
def factors(number):
    try:
        num = int(number)
        if num <= 0:
            return jsonify({"error": "Please provide a positive integer"}), 400
        factors = get_prime_factors(num)
        return jsonify(factors)
    except ValueError:
        return jsonify({"error": "Please provide a valid integer"}), 400

if __name__ == "__main__":
    app.run(host='0.0.0.0')