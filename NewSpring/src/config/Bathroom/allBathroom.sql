
select '一', count(t1.studentid) countstudentid
  from bathroom t1
 where t1.bathroom = '1'
   and type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (
        
        select c
          from (select x.studentid as c, y.studentid as d
                   from (select t1.studentid studentid, type as a, time
                           from bathroom t1
                          where t1.bathroom = '1'
                            and type = 'in'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) x,
                        
                        (select t1.studentid studentid, type as b, time
                           from bathroom t1
                          where t1.bathroom = '1'
                            and type = 'out'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) y
                 
                  where x.studentid = y.studentid))

union all

select '二', count(t1.studentid) countstudentid
  from bathroom t1
 where t1.bathroom = '2'
   and type = 'in'
   and time < trunc(sysdate, 'mi')
   and time > sysdate - 1 / 24
   and studentid not in
       (
        
        select c
          from (select x.studentid as c, y.studentid as d
                   from (select t1.studentid studentid, type as a, time
                           from bathroom t1
                          where t1.bathroom = '2'
                            and type = 'in'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) x,
                        
                        (select t1.studentid studentid, type as b, time
                           from bathroom t1
                          where t1.bathroom = '2'
                            and type = 'out'
                            and time < trunc(sysdate, 'mi')
                            and time > sysdate - 1 / 24) y
                 
                  where x.studentid = y.studentid))
