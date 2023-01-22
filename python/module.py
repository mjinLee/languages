# module(모듈)
'''
    : 한 번 정의했던 변수나 함수, 클래스 등을 다른 python 프로그램에서도 불러와
    사용할 수 있도록 하나의 파일로 모아놓는 방법
    : python에서 기본적으로 제공하는 모듈뿐만 아니라 다른 사람이 만든 모듈을
    사용하거나 자신이 직접 새로운 모듈을 작성하여 사용할 수도 있음
    - import 모듈명 : 해당 모듈 전체를 불러옴, 모듈에 포함된 변수나 함수를 사용할 때
     매번 모듈명과 함께 닷(.) 연산자를 사용해야 함
    - from 모듈명 import * : 해당 모듈 전체를 불러옴, 변수명이나 함수명만으로도 간편하게 사용
    - from 모듈명 import 함수명 또는 클래스명 
'''
#
import math
print(math.pi) # 3.141592653589793
print(math.pow(2,2)) # 4.0
#
from math import *
print(pi) # 3.141592653589793
print(pow(2,2)) # 4.0
#
e = '사용자가 정의한 변수 e'
print(e) # 사용자가 정의한 변수 e
from math import *
print(e) # 2.718281828459045
print(pi) # 3.141592653589793
#
e = '사용자가 정의한 변수 e'
print(e) # 사용자가 정의한 변수 e
from math import pi
print(e) # 사용자가 정의한 변수 e
print(pi) # 3.141592653589793