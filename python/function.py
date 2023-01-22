# function
# 함수 선언
def hello():
    print('hi')
    print('holla')
    print('hallo')
hello() # 함수 호출
#
def sum(a,b):
    print(a + b)
sum(1,2) # 3
sum(3,5) # 8
#
def mul(a,b):
    return a * b
c = mul(3,4)
print(c) # 12
print(mul(2,4)) # 8
# 인수 전달 시 매개변수 지정
def sub(a, b):
    print('a - b = ',a-b)
sub(a=6,b=3) # 3
# 매개변수의 기본값 설정
def total(a, b=5, c=10):
    print(a+b+c)
total(1) # 16
total(1,2) # 13
total(1,2,3) # 6
'''
    def total(a=5, b, c=10):
        print(a + b + c)
    total(1) # b 에 값이 들어가지 않으므로 Syntax Error
'''
# 가변 매개변수 (*매개변수명) : 함수를 호출할 때 몇 개의 인수가 전달될지 미리 알 수 없는 경우
# 이렇게 선언된 가변 매개변수에는 함수가 호출될 때 모든 인수가 tuple의 형태로 저장됨
def add(*para):
    print(para)
    total = 0
    for pa in para:
        total += pa
    return total
print(add(10)) # (10,) 10
print(add(10,30)) # (10,30) 40
print(add(10,30,50)) # (10,30,50) 90
# 가변 매개변수로 딕셔너리 사용 (**매개변수명)
def print_item(**dicts):
    for item in dicts.items():
        print(item)
print_item(one=1) # ('one',1)
print_item(eins=1, two=2) # ('eins', 1) ('two', 2)
print_item(하나=1, twei=2, drei=3) # ('하나', 1) ('twei', 2) ('drei', 3)
# 결과 값 여러 개 반환 : tuple 사용
def res(a,b):
    sum = a + b
    sub = a - b
    return sum, sub
i, j = res(5,2)
print(i) # 7
print(j) # 3
# lambda(람다) : 간단한 함수의 선언과 호출을 하나의 식으로 간략히 표현
''' - 일반 함수와는 달리 이름을 가지지 않, map(),filter()와 같이 함수 자체를
     인수로 전달받는 함수에서 자주 사용
    - lambda 매개변수1, 매개변수2,,,: 매개변수이용한표현식
'''
def sum(a,b):
    return a + b
print(sum(1,2)) # 3
print((lambda a, b: a+b)(1,2)) # 3
# 지역변수 local variable : 함수 내에 선언된 변수; 함수 내에서만 사용 가능
def func():
    local_var = '지역 변수'
    print(local_var)
func() # 지역 변수
# 전역변수 global variable : 함수 외부에 선언된 변수;
# 모든 함수에서 global 키워드로 재선언하면 접근 가능
def func2():
    global global_var # 전역변수를 사용하기 위해 선언
    local_var2 = '지역변수'
    print(local_var2)
    print(global_var)
global_var = '전역변수'
func2() # 지역변수 전역변수
print(global_var) # 전역변수
'''
    - 프로그램이 실행되는 내내 변하지 않아야 하거나 여러 함수에서 함께 사용하는 값 : 전역변수
    - 특정함수에서만 사용되는 값 : 지역변수로 선언
'''