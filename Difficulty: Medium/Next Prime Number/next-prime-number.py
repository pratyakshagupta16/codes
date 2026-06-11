def nextPrime(n):

    def isPrime(x):
        if x <= 1:
            return False

        i = 2
        while i * i <= x:
            if x % i == 0:
                return False
            i += 1

        return True

    num = n + 1

    while not isPrime(num):
        num += 1

    return num