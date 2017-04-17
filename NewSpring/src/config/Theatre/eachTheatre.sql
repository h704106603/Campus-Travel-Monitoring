select '当前人数', count(t1.studentid) countstudentid
  from theatre t1
 where t1.theatre = '{id}'
   and type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (select c
          from (select x.studentid as c, y.studentid as d
                  from (select t1.studentid studentid, type as a, time
                          from theatre t1
                         where t1.theatre = '{id}'
                           and type = 'in'
                           and time < trunc(sysdate, 'mi')
                           and time > sysdate - 1 / 24) x,
                       
                       (select t1.studentid studentid, type as b, time
                          from theatre t1
                         where t1.theatre = '{id}'
                           and type = 'out'
                           and time < trunc(sysdate, 'mi')
                           and time > sysdate - 1 / 24) y
                
                 where x.studentid = y.studentid))

union all
select '空位', {max} - count(t1.studentid) countstudentid
  from theatre t1
 where t1.theatre = '{id}'
   and type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (select c
          from (select x.studentid as c, y.studentid as d
                  from (select t1.studentid studentid, type as a, time
                          from theatre t1
                         where t1.theatre = '{id}'
                           and type = 'in'
                           and time < trunc(sysdate, 'mi')
                           and time > sysdate - 1 / 24) x,
                       
                       (select t1.studentid studentid, type as b, time
                          from theatre t1
                         where t1.theatre = '{id}'
                           and type = 'out'
                           and time < trunc(sysdate, 'mi')
                           and time > sysdate - 1 / 24) y
                
                 where x.studentid = y.studentid))
