#include<iostream>
using namespace std;

int main(){
    int num;
    cout << "숫자 입력 : ";
    cin >> num;
    //
    if(num<5)
        cout << "입력한 수는 5보다 작음"<< endl;
    else if(num>3)
        cout << "입력한 수는 3보다 큼"<< endl;
    else{
        if(num == 5)
            cout << "입력한 수는 5"<<endl;
        else
            cout << "입력한 수는 5보다 큼"<< endl;
    }
    //
    switch (num) {
        case 1:
            cout << "입력하신 수는 1입니다." << endl;
            break;
        case 2:
            cout << "입력하신 수는 2입니다." << endl;
            break;
        default:
            cout << "1부터 5까지의 수만 입력해 주세요!" << endl;
            break;
    }
    char ch;
    switch (ch)
    {
    case 'a':
    case 'A':
        cout <<"A학점"<<endl;
        break;
    
    default:
        cout << "정확히 입력하시오"<<endl;
        break;
    }
}
