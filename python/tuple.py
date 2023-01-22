# tuple
tu1 = (1,2,3) 
print(tu1) # (1,2,3)
tu2 = 1,2,3
print(tu2) # (1,2,3)
tu3 = (1,)
print(tu3) # (1,)
tu4 = (1)
print(tu4) # 1
#
tu5 = tuple(['eins','twei','drei'])
print(tu1[0]) # 1
print(tu5[-1]) # drei
# 자르기
print(tu1[1:]) # (2, 3)
print(tu5[:2]) # ('eins', 'twei')
# 연산
print(tu1 + tu5) # (1, 2, 3, 'eins', 'twei', 'drei')
print(tu1 * 2) # (1, 2, 3, 1, 2, 3)
# 패킹(packing) : 여러 타입의 데이터를 하나의 튜플이나 리스트로 묶어 선언
tuple1 = 10, 'zhen', True
# 언패킹(unpacking) : 하나의 튜플이나 리스트의 요소들을 여러 개의 변수에 나누어 대입
a, b, c = tuple1
print(a) # 10
print(b) # zhen
print(c) # True
# 특정 요소 포함 여부
print(10 in tuple1) # True
print('vier' in tuple1) # False
print('vier' not in tuple1) # True