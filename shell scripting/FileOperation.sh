
echo Enter the file name
read file
c=`cat $file | wc -c`
w=`cat $file | wc -w`
lines=`grep -c "." $file`
echo number of character in $file is $c
echo nuber of words in $file is $w
echo number of lines in $file is $lines