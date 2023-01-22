# 예외 처리(exception handling)
'''
    try:
        예외가 발생할 가능성이 있는 코드
    except [처리할 예외명 [as 에러 메시지 변수]]:
        try 절에서 발생한 예외를 처리할 코드
    [else:]
        try 절에서 예외가 발생하지 않았을 경우에만 실행될 코드
    [finally:]
        try 절이 실행되고 나면 언제나 마지막에 실행될 코드(예외 여부와 상관없이)
'''
#
try:
    3 / 0
except IndexError as e:
    print('인덱스가 안 맞음', e)
except ZeroDivisionError as e:
    print('0으로 나누면 안 됨', e) # 0으로 나누면 안 됨 division by zero
print('프로그램이 정상적으로 종료됨') # 프로그램이 정상적으로 종료됨
#
try:
    pass
except IndexError:
    print("인덱스가 안 맞음")
except ZeroDivisionError:
    print("0으로 나누면 안 됨")
else:
    print("예외가 발생하지 않음") # 예외가 발생하지 않음
print("프로그램이 정상적으로 종료됨") # 프로그램이 정상적으로 종료됨
#
try:
    3 / 0
except IndexError:
    print("인덱스가 안 맞음")
except ZeroDivisionError:
    print("0으로 나누면 안 됨") # 0으로 나누면 안 됨
finally:
    print("예외에 상관없이 언제나 실행됨") # 예외에 상관없이 언제나 실행됨
print("프로그램이 정상적으로 종료됨") # 프로그램이 정상적으로 종료됨
#
# 예외 발생시키기(raise 키워드 사용하여 강제로 예외 발생시킬 수 있음)
# 예) 부모 클래스를 상속받는 자식 클래스에서 부모 클래스의 어떤 메소드는 반드시 구현하도록
#  만들고 싶다면, NotImplementedError를 사용하여 이를 강제할 수 있음
class Bird:
    def birdsong(self):
        raise NotImplementedError
'''
class Chicken(Bird):
    pass
my_chicken = Chicken()
my_chicken.birdsong()
'''
# raise NotImplementedError
# NotImplementedError => 프로그램 강제 종료
# 자식 클래스인 Chicken 클래스에서 부모 클래스의 birdsong() 메소드를 구현하지 않아서
#  raise 키워드에 의해 NotImplementedError가 강제로 발생되었기 때문
class Chicken2(Bird):
    def birdsong(self):
        print("짹짹")
my_chicken2 = Chicken2()
my_chicken2.birdsong() # 짹짹