update associationdetails
   set count = (select count + 1 from associationdetails where id = '{id}')
 where id = '{id}'
