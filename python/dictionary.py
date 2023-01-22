# dictionary
# 요소 = key : value
dict1 = {'eins':1, 'twei':'two', 'pie':3.14}
print(dict1) # {'eins': 1, 'twei': 'two', 'pie': 3.14}
dict2 = dict({'eins':1, 'twei':'two', 'pie':3.14})
dict3 = dict([('eins',1), ('twei','two'), ('pie',3.14)])
dict4 = dict(eins=1, twei='two', pie=3.14) # '='를 바로 사용하기 위해서는 key는 문자열.
'''
    key는 정수, 문자열, 실수 등도 사용가능
    list 나 dictionary 와 같이 변경할 수 있는 타입의 값은 사용 x
'''
di1 = {'하나':1, 2:'two', 3.14:'pi'}
# tuple 은 값을 변경할 수 없는 타입이므로 dictionary 의 key 로 사용될 수 있음
di2 = {('ten',10):['열',10.0]} 
#
dd1 = dict({'자바':80,'php':90,'html':70})
print(dd1['자바']) # 80
print(dd1.get('자바')) # 80
print(dd1.get('python')) # None : '값이 없음'을 나타내는 python 의 예약 상수
# 추가, 제거
dd1['python'] = 100
print(dd1) # {'자바': 80, 'php': 90, 'html': 70, 'python': 100}
del dd1['php']
print(dd1) # {'자바': 80, 'html': 70, 'python': 100}
dd1['자바'] =  100
print(dd1) # {'자바': 100, 'html': 70, 'python': 100}
dd1.clear()
print(dd1) # {}
# 정보 얻기
dd1 = dict({'자바':80,'php':90,'html':70})
print(dd1.keys()) # dict_keys(['자바', 'php', 'html'])
print(dd1.values()) # dict_values([80, 90, 70])
print(dd1.items()) # dict_items([('자바', 80), ('php', 90), ('html', 70)])
print('html' in dd1) # True
print('python' in dd1) # False