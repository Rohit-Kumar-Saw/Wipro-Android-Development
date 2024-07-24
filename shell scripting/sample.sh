 name1="Rohit"
 name2="Ayush"
 name3="Pritam"

 names=${name1}%${name2}%${name3}
 names="$name1" "$name2" "$name3"

 echo ${#name1}
 echo $names