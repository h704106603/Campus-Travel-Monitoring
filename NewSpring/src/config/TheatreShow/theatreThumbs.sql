update theatreshowdetails
   set count = (select count + 1 from theatreshowdetails where id = '{id}')
 where id = '{id}'
