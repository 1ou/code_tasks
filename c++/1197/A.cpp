#include <iostream>
int main()
{
    long count_requests = 0;
    std::cin >> count_requests;

    for (int i = 0; i < count_requests; i++) {
         long n_dosk = 0;
         std::cin >> n_dosk;
         long *arr = new long[n_dosk];
	 for (int j = 0; j < sizeof(arr) / sizeof(arr[0]); j++) {
               std::cin >> arr[j];
         }
	 delete arr;
    }
    std::cout << count_requests;
    return 0;
}