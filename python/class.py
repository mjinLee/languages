# 클래스와 객체
'''
    - 클래스(class; 함수와 변수를 한꺼번에 묶어서 관리)
    - 객체(object)
    하나의 class로부터 무수히 많은 object 생성 가능
    - 속성(attribute; 클래스에 포함되는 변수)
    - 메소드(method; 클래스에 포함되는 함수)
    클래스의 속성과 메소드를 한꺼번에 클래스 멤버라고도 부름

'''
# 
class Dog: # 클래스 선언
    name = '솜솜이' # 속성 선언
    age = 2
    breed = '포메라니안'

    def bark(self): # 메소드 선언
        print(self.name + '가 멍멍 짖음')
my_dog = Dog() # 인스턴트 선언
print(my_dog.breed) # 인스턴트의 속성 접근 # 포메라니안
my_dog.bark() # 인스턴트의 메소드 호출 # 솜솜이가 멍멍 짖음
# 객체와 인스턴스는 별개의 것이 아니며, 객체를 바라보는 관점의 차이
# my_dog는 객체이면서 동시에 Dog 클래스의 인스턴스
#
# 초기화 메소드 : '__init__'로 이름이 고정되어 있음
class Cat:
    def __init__(self, name):
        self.name = name
    def bark2(self):
        print(self.name + '가 야옹')
my_cat = Cat('야옹이') # 인스턴스 생성
my_cat.bark2() # 인스턴스의 메소드 호출 # 야옹이가 야옹
# 클래스 변수 : 해당 클래스에서 생성된 모든 인스턴스가 값을 공유
# 인스턴스 변수 : __init__() 메소드 내에서 선언된 변수; 인스턴스가 생성될 때마다 새로운 값이 할당
class animals: # 클래스 선언
    sound = '멍멍' # 클래스 변수 선언
    def __init__(self, name):
        self.name = name # 인스턴스 변수 선언
    def bark3(self):
        print(self.name + '가 냥냥하고 짖음')
my_dogs = animals('멍멍이') # 인스턴스 생성
my_cats = animals('야옹이') # 인스턴스 생성
print(my_dogs.sound) # 클래스 변수에 접근 # 멍멍
print(my_dogs.name) # 인스턴스 변수에 접근 # 멍멍이
my_cats.bark3() # 인스턴스의 메소드 호출 # 야옹이가 냥냥하고 짖음
print(my_cats.name) # 인스턴스 변수에 접근 # 야옹이
''' 
    - 인스턴스 간에 값을 서로 공유하지 않아도 되는 변수는 인스턴스 변수로 선언하고,
     같은 값을 공유해야만 하는 변수는 클래스 변수로 선언
    - 어떤 변수를 클래스 변수로 선언하고 인스턴스 변수로 선언할지 모르겠다면,
     프로그램의 안전성을 위해 무조건 인스턴스 변수로 선언하는 것이 좋음
'''
#
# 상속(inferitance)
# 기존 클래스를 직접 수정하지 않고, 기능을 추가하거나 변경할 때 사용
# 이미 존재하던 클래스 : 부모클래스, 기초클래스
# 상속을 통해 새롭게 생성된 클래스 : 자식클래스, 파생클래스
class Bird:
    def __init__(self):
        self.flying = True
    def birdsong(self):
        print('새소리')
class Sparrow(Bird):
    def birdsong(self):
        #return super().birdsong()
        print('짹짹')
my_sparrow = Sparrow()
print(my_sparrow.flying) # True
my_sparrow.birdsong() # 짹짹
# 메소드 오버라이딩 : 부모 클래스에서 이미 정의된 메소드를 자식 클래스에서 같은 이름으로 재정의하는 것
class Chicken(Bird):
    def __init__(self):
        #super().__init__()
        self.flying = False
my_chicken = Chicken()
my_chicken.birdsong() # 새소리
print(my_chicken.flying) # False
#
# 접근 제어
'''
    - c++에선 public / private / protected
    - python은 접근 제어자를 사용하지 않고, 변수나 메소드의 이름을 작성할 때 작명법에 따라
      접근 제어를 구현
      public : 멤버 이름에 어떠한 언더스코어(_)도 포함되지 않음 => name
      private : 두 개의 언더스코어(__)가 접두사로 포함 => __name
      protected : 한 개의 언더스크어(_)가 접두사로 포함 => _name
'''