select main.item_id, main.item_name, main.rarity
from ITEM_INFO as main join 
(select child.item_id 
from ITEM_INFO as parent join ITEM_TREE as child
on parent.ITEM_ID = child.PARENT_ITEM_ID
where parent.rarity = 'rare') as sub
on main.item_id = sub.item_id
order by main.item_id desc;
