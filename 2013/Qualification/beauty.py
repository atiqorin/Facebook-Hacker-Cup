from collections import Counter
import re


def beauty(s):
    s = re.sub(r'[^a-z]', '', s.lower())
    r = 0
    #print(Counter(s).items())
    for j, (char, count) in enumerate(sorted(Counter(s).items(),
                                             key=lambda item: item[1], reverse=True)):
        r += (26 - j) * count
    return r


if __name__ == '__main__':
    import sys
    INPUT = open(sys.argv[1])
    f = open(sys.argv[2], "w+")
    T = int(INPUT.readline())
    for c in range(T):
        f.write("Case #{}: {}\n".format(c + 1, beauty(INPUT.readline())))
    f.close()