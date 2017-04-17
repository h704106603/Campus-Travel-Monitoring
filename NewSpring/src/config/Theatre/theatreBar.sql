
          
          
select startTime,sum(todaystudentNumber),sum(yeterdaystudentNumber) from (
select temptime.startTime startTime, nvl(todaytheatre.studentNumber, 0) todaystudentNumber ,nvl(yesterdaytheatre.studentNumber, 0) yeterdaystudentNumber
  from (select to_char(trunc(decode(mod(to_number(to_char(t.time, 'mi')), 2),
                                     0,
                                     t.time,
                                     t.time - 1 / 24 / 60),
                              'mi'),
                        'hh24:mi') startTime,
                count(t.studentid) studentNumber
           from theatre t
          where t.theatre = '{id}'
            and t.type = 'in'
          
            and time < trunc(sysdate,'mi')
            and time > sysdate - 1 / 24
          group by t.time
          ) todaytheatre,
          
          (select to_char(trunc(decode(mod(to_number(to_char(t.time, 'mi')), 2),
                                     0,
                                     t.time,
                                     t.time - 1 / 24 / 60),
                              'mi'),
                        'hh24:mi') startTime,
                count(t.studentid) studentNumber
           from theatre t
          where t.theatre = '{id}'
            and time > sysdate - 1 / 24  - 1
            and time < sysdate - 1 
            and t.type = 'in'
          group by t.time
          ) yesterdaytheatre,
       
        (select to_char(2 * (level - 18) / 24 / 60 +
                       trunc(decode(mod(to_number(to_char(sysdate, 'mi')), 2),
                                    0,
                                    sysdate,
                                    sysdate - 1 / 24 / 60),
                             'mi'),
                       'hh24:mi') startTime
          from dual
        connect by rownum <= 20) temptime
       
       where temptime.startTime = todaytheatre.startTime(+)
         and temptime.startTime = yesterdaytheatre.startTime(+)
       order by temptime.startTime
       ) group by startTime 
       order by startTime
     
