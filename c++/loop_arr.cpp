#include<iostream>
#include<iomanip>
using namespace std;

int main(){
    // 범위 기반의 for문 : c++11~
    int arr1[5] = {1,3,5,7,9};
    for(int element : arr1){
        cout << element << " ";
    } // 1 3 5 7 9

    // 배열 길이
    int grade[] = {85,75,90};
    int len = sizeof(grade)/sizeof(grade[0]);
    cout << "배열 길이 : "<<len<<endl; // 3

    // 배열의 일부 요소만 초기화 : 원하는 배열 요소만 초기화, 초기화x=>0
    int arr_col_len, arr_row_len;
    int arr[3][4]={ {10,20},{30,40,50,60},{0,0,70,80}};
    arr_col_len = sizeof(arr[0])/sizeof(arr[0][0]); // 열의 길이
    arr_col_len = (sizeof(arr)/arr_col_len)/sizeof(arr[0][0]); // 행의 길이
    cout<<"arr 배열 요소 값"<<endl;
    for (int i = 0; i < arr_row_len; i++) {
		for (int j = 0; j < arr_col_len; j++) {
			cout << setw(4) << arr[i][j];
		}
		cout << endl;
	}
    // 배열 길이 자동 설정
    // 행의 길이는 생략할 수 있지만, 열의 길이는 반드시 명시
    int ar[][4]={ {10,20},{30,40,50,60},{0,0,70,80}};


    return 0;
}