"""
[topics]
string

[sketch]
순서
whitespace
+/-
numbers
between MAX_INT and MIN_INT constraints
random characters
"""
# T.O = O(N) / S.O = O(1)
MAX_INT = 2 ** 31 - 1
MIN_INT = -2 ** 31

i = 0
res = 0

# whitespace
while i < len(str) and str[i] == ' ':
    i += 1

# +/-
if i < len(str) and str[i] == '-':
    i += 1
    negative = -1
elif i < len(str) and str[i] == '+':
    i += 1

# numbers
checker = set('0123456789')
while i < len(str) and str[i] in checker:
    res = res * 10 + int(str[i])
    i += 1

# check the MAX / MIN int
res = res * negative
if res < 0:
    return max(res, MIN_INT)
return min(res, MAX_INT)