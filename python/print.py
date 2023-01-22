# print
print("hello") # hello
print("py","th","on") # py th on
print(111) # 111
print([1,2,3]) # [1,2,3]

'''
    - python에서 변수명 생성 규칙)
       변수명은 영문자(대소문자), 숫자, 언더스코어(_)로만 작성
       변수명은 숫자로 시작할 수 없음. 반드시 영문자나 언더스코어(_)로만 시작
       변수명은 대소문자를 구분함
       변수명에는 python에서 미리 정의된 예약어(reserved words)는 사용할 수 없음
    - 미리 정의된 예약어(reserved words)
       False | await | else | import | pass | None | break | except | in | raise |
       True | class | finally | is | return | and | continue | for | lambda | try |
       as | def | from | nonlocal | while | assert | del | global | not | with |
       async | elif | if | or | yield
'''

var = input("input: ") # scanf
print(var)

var = 7
print(type(var)) # class 'int'
var = "abc"
print(type(var)) # class 'str'
#
print(bool(1)) # boolean : true
print(bool("")) # false
#
print("python")
print('python')
print("""python
python python
pyton python""")
print('''aaaaaaaa
aaaaaaaaa
aaa''')
print('abc\n'
'aaaaaa\n'
'qwerty')
#
i = "python "
j = 'string'
print(i + j) # python string
print(i * 3) # python python python
#
py = "python abc 123!"
print(py[0]) # p
print(py[5]) # n
print(py[-1]) # !
print(len(py)) # 15
#
py = "python abcdef 123456"
print(py[4]) # o
print(py[4:7]) # on
print(py[:4]) # pyth
print(py[4:]) # on abcdef 123456
#
py = 'python programming'
print(py.count('p')) # 2
print(py.find('o')) # 4
print(py.index('o')) # 4
print(py.find('z')) # -1
# 대문자, 소문자
py = "Python"
print(py.upper()) # PYTHON
print(py.lower()) # python
#
py = "python programming"
print(py.replace("python","java")) # 문자열 변경 java programming
print(py.split(' ')) # 문자열 나누기 ['python','programming']
print(py.split()) # ['python','programming']