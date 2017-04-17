
select '一层阅览室', count(t1.studentid) countstudentid
  from library t1
 where t1.library = '1'
   and type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (
        
        select c
          from (select x.studentid as c, y.studentid as d
                   from (select t1.studentid studentid, type as a, time
                           from library t1
                          where t1.library = '1'
                            and type = 'in'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) x,
                        
                        (select t1.studentid studentid, type as b, time
                           from library t1
                          where t1.library = '1'
                            and type = 'out'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) y
                 
                  where x.studentid = y.studentid))

union all

select '电子阅览室', count(t1.studentid) countstudentid
  from library t1
 where t1.library = '2'
   and type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (
        
        select c
          from (select x.studentid as c, y.studentid as d
                   from (select t1.studentid studentid, type as a, time
                           from library t1
                          where t1.library = '2'
                            and type = 'in'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) x,
                        
                        (select t1.studentid studentid, type as b, time
                           from library t1
                          where t1.library = '2'
                            and type = 'out'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) y
                 
                  where x.studentid = y.studentid))
                  
union all

select '自习室', count(t1.studentid) countstudentid
  from library t1
 where t1.library = '3'
   and type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (
        
        select c
          from (select x.studentid as c, y.studentid as d
                   from (select t1.studentid studentid, type as a, time
                           from library t1
                          where t1.library = '3'
                            and type = 'in'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) x,
                        
                        (select t1.studentid studentid, type as b, time
                           from library t1
                          where t1.library = '3'
                            and type = 'out'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) y
                 
                  where x.studentid = y.studentid))
