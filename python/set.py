# set
# 출력 결과는 실행할 때마다 다름 -> set는 요소들 사이의 순서는 신경 쓰지 않기 때문
s1 = {1,2,3}
print(s1) # {1,2,3}
s2 = set('Python')
print(s2) # {'o','n','y','h','P','t'}
# empty set
set1 = {}
print(type(set1)) # class 'dict' => 딕셔너리
set2 = set()
print(type(set2)) # class 'set'
# 추가, 제거
s1.add(4)
print(s1) # {1, 2, 3, 4}
s1.update((5,6))
print(s1) # {1, 2, 3, 4, 5, 6}
s1.remove(2)
print(s1) # {1, 3, 4, 5, 6}
# 연산
set1 = {1, 2, 3, 4, 5}
print(set1) # {1, 2, 3, 4, 5}
set2 = set((1, 3, 5, 7, 9))  
print(set2) # {1, 3, 5, 7, 9}
print(set1 | set2) # 합집합 {1, 2, 3, 4, 5, 7, 9}
print(set1 & set2) # 교집합 {1, 3, 5}
print(set1 - set2) # 차집합 {2, 4}
print(set1 ^ set2) # 여집합 = 합집합 - 교집합 {2, 4, 7, 9}