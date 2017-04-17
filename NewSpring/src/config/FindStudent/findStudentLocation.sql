select studentid, time, {location}, type from (
select t.studentid, t.time, t.{location}, t.type
  from {location} t
 where t.studentid = '{friendId}'
  and type = 'in'
  order by t.time desc) where rownum = 1
 union all
 select studentid, time, {location}, type from (
select t.studentid, t.time, t.{location}, t.type
  from {location} t
 where t.studentid = '{friendId}'
  and type = 'out'
  order by t.time desc) where rownum = 1
  