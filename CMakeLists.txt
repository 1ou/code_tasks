cmake_minimum_required(VERSION 3.3)
project(test_build)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")

set(BUILD_1 1204)
set(SOURCE_FILES_1 ./1204/A.cpp)
add_executable(${BUILD_1} ${SOURCE_FILES_1})
#
#set(BUILD_2 insertion_sort)
#set(SOURCE_FILES_2 ./sort/InsertionSort.cpp)
#add_executable(${BUILD_2} ${SOURCE_FILES_2})
#
#set(BUILD_3 selection_sort)
#set(SOURCE_FILES_3 ./sort/SelectionSort.cpp)
#add_executable(${BUILD_3} ${SOURCE_FILES_3})
