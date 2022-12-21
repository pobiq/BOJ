N = input()

count = 0

for i in range(len(N)-1):
    count += 9 * (10 ** i) * (i + 1)

count += (int(N) - 10**(len(N)-1) + 1) * len(N)

print(count)