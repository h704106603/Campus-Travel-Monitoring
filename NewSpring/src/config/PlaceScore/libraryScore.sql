select '当前人数', (400-count(t1.studentid))/400*100 countstudentid
  from library t1
 
   where type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (select c
          from (select x.studentid as c, y.studentid as d
                  from (select t1.studentid studentid, type as a, time
                          from library t1
                         
                           where type = 'in'
                           and time < trunc(sysdate, 'mi')
                           and time > sysdate - 1 / 24) x,
                       
                       (select t1.studentid studentid, type as b, time
                          from library t1
                         
                           where type = 'out'
                           and time < trunc(sysdate, 'mi')
                           and time > sysdate - 1 / 24) y
                
                 where x.studentid = y.studentid))
