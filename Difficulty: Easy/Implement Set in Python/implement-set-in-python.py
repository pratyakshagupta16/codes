st = {int(x) for x in input().split()}
i = int(input())
r = int(input())

st.add(i)


for i in sorted(st):
    print(i, end=' ')
print()

st.remove(r)

for i in sorted(st):
    print(i, end=' ')
print()

sum = sum(st)


print(sum)