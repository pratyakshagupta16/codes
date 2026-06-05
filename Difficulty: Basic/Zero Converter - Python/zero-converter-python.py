def pos(n):

    if n == 0:
        print("already Zero")

    else:
        n -= 1
        while n >= 0:
            print(n, end=" ")
            n -= 1


def neg(n):

    while n <= 0:
        print(n, end=" ")
        n += 1