# 조건문
salmon = 'tasty'
if salmon == 'tasty':
    print('delicious')
else:
    print('nope')
#
season = 'winter'
if season == 'spring':
    print('flower')
elif season == 'summer':
    print('icecream')
elif season == 'fall':
    print('autumn')
elif season == 'winter':
    print('snow')
#
temp = 18
if temp < 25:
    pass    # 아무 동작도 수행 X
else:
    print('turn on')
# 반복문
i = 1
while i < 5:
    print('python '+str(i))
    i += 1
# while True:
#   반복 실행하고자 하는 명령문
#
str = 'python'
for ch in str:
    print(ch)
#
# 구구단 출력 (2 ~ 9 단 중 5단 까지만 출력)
for col in range(2,10):
    if col > 5:
        break
    for row in range(1,10):
        print(col,'x',row,'=',col*row)
# 1 ~ 10 중 홀수만 출력
for n in range(1,11):
    if n % 2 == 0:
        continue
    print(n,'은 홀수임')