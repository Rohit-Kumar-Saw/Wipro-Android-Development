arr=("Rohit" 5 "ARJIT" 34 "Amanda")

#substing
echo ${arr[@]:0:2}
unset arr[3]
echo ${arr[*]}
echo ${#arr[@]}
echo ${arr[0]}
echo ${arr[2]:0:3}
echo ${arr[2]:3}

search_result=$(echo "${arr[@]}" | grep -c ayush)

replaced_element=$(echo "${arr[@]/Aryan/Mohan}")
echo $search_result