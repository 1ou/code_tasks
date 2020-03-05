cmake_minimum_required(VERSION 3.3)
project(test_build)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++17")

set(BUILD_1 A)
set(SOURCE_FILES_1 1316/A.cpp)
add_executable(${BUILD_1} ${SOURCE_FILES_1})

