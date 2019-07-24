select p.ProductName, sum(od.UnitPrice * od.Quantity) from products as p  
join orderdetails as od on p.ProductID = od.ProductID
join categories as c on c.CategoryID = p.CategoryID
join orders as o  on o.OrderID = od.OrderID
where year(o.OrderDate) = 1996 and
c.CategoryName = "Beverages" group by p.ProductName