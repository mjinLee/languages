# 파일 입출력
# input(), print()
# 파일 열고, 닫기
# open(), close()
fp = open('test.txt','w')
fp.close()
# 파일객체 = open(파일명, 파일모드문자열)
'''
    * 파일모드문자열
    - 가장 먼저 파일의 사용 용도 결정하는 문자열이 나옴.
      r(readmode; 읽기전용모드(기본값)) 
      w(write mode; 쓰기전용모드)
      a(append mode; 파일의 마지막에 새로운 데이터 추가)
    - 그 다음으로 파일의 데이터를 어떤 방식으로 입출력할지를 결정하는 문자열이 이어짐.
      t(text mode; 해당 파일의 데이터를 텍스트 파일로 인식하고 입출력(기본값))
      b(bianry mode; 바이너리 파일로 인식하고 입출력)
    - 마지막으로 다음과 같은 파일 모드 문자열 추가 가능
      x(exclusive mode; 열고자 하는 파일이 이미 존재하면 파일 개방에 실패)
      +(update mode; 파일을 읽을 수도 있고 쓸 수도 있도록 개방)
    - 예) 'w'로 파일을 열었을 때 같은 이름의 파일이 이미 존재하면, 해당 파일에 저장되어 있던
     모든 내용이 제거되고 파일이 열림. 하지만 같은 이름의 파일이 존재하지 않으면, 해당 이름의
     새로운 파일이 만들어짐
    - 'r', 't', 'rt'
'''
# 파일 내용 읽기
# read(), readline(), readlines()
fp = open('test.txt','r')
file_data = fp.read()
print(file_data) # 해당 파일의 모든 내용을 읽어 들여 하나의 문자열로 반환
while True:
    file_line = fp.readline() # 한 번에 한 라인만 읽어 들여 문자열로 반환
    if not file_line:
        break
    print(file_line, end='') # 모든 내용 읽기 위해 반복문 사용해 출력
file_lines = fp.readlines() # 모든 라인을 순서대로 읽어 들여 각각의 라인을
print(file_lines) # 하나의 요소로 저장하는 하나의 리스트를 반환 ('\n'까지 함께 저장됨)
fp.close()
# 파일에 내용 추가
fp = open('test.txt','a') # 기존에 존재하는 파일에 새로운 내용 추가하므로 'a' 사용
fp.write('\n추가된 라인')
fp.close()
# 자동으로 파일 닫기
# with open(파일명, 파일모드문자열) as 파일객체:
with open('test.txt','r') as fp:
    file_datas = fp.read()
    print(file_datas)
# with 문을 사용하면 close() 함수를 사용하지 않아도 열어놓은 파일을 자동으로 닫아줌