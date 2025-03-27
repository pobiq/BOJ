with max_length as( 
    select i.fish_type, max(i.length)
    from fish_info as i join fish_name_info as n
    on i.fish_type = n.fish_type
    group by i.fish_type
)

select 
    i.id, n.fish_name, i.length 
from 
    fish_info i join fish_name_info n
    on i.fish_type = n.fish_type
where
    (i.fish_type, i.length) in (
        select *
        from max_length
    )
order by
    i.id asc;