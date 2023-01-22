# list
# 선언
temp = [1,2,3,4]
# 출력
for t in temp:
    print(t)
print(len(temp)) # 4
print(temp[0]) # 1
print(temp[-1]) # 4
print(temp[1]+temp[3]) # 6
# 자르기(slicing)
print(temp[3]) # 4
print(temp[1:3]) # [2,3]
print(temp[:3]) # [1,2,3]
print(temp[3:]) # [4]
print(temp) # [1,2,3,4]
# 복사하기
copy = temp
copy.append(5)
print(copy) # [1,2,3,4,5]
print(temp) # [1,2,3,4,5]
copy1 = temp[:]
copy1.append(6)
print(copy1) # [1,2,3,4,5,6]
print(temp) # [1,2,3,4,5]
# 연산
tmp1 = [1,2,3]
tmp2 = list((4,5,6))
print(tmp1+tmp2) # [1,2,3,4,5,6]
print(tmp1 * 3) # [1,2,3,1,2,3,1,2,3]
tmp1.extend(tmp2) 
print(tmp1) # [1,2,3,4,5,6]
# 추가, 제거
temp.append(2)
print(temp) # [1,2,3,4,5,2]
temp.remove(3)
print(temp) # [1,2,4,5,2]
temp.remove(2)
print(temp) # [1,4,5,2]
# 삽입, 꺼내기
temp.insert(3,8) #(n번째 위치에, 숫자 m 삽입)
print(temp) # [1,4,5,8,2]
temp.pop(4) # 0 ~ 4 중 4번째 값 꺼냄
print(temp) # [1,4,5,8]
# 뒤집기, 정렬
list1 = [5,2,4,1,3]
list2 = [5,2,4,1,3]
list1.reverse()
print(list1) # [3,1,4,2,5]
list1.sort() # sort : 원본 변경, sorted : 원본은 변경하지 않고 정렬된 새로운 리스트 반환
print(list1) # [1,2,3,4,5]
print(sorted(list2)) # [1,2,3,4,5]
print(list2) # [5,2,4,1,3]
# 중첩 리스트
matrix = [[1,2,3],['eins','twei','drei']]
print(matrix[0]) # [1,2,3]
print(matrix[0][0]) # 1
print(matrix[1][2]) # drei