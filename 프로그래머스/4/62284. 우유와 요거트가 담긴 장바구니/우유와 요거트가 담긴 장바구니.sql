SELECT CART_ID
FROM CART_PRODUCTS P
GROUP BY CART_ID
HAVING GROUP_CONCAT(NAME) LIKE '%Milk%Yogurt%' OR GROUP_CONCAT(NAME) LIKE '%Yogurt%Milk%'
ORDER BY CART_ID
