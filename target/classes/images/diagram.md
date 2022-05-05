classDiagram
direction BT
class cart {
   varchar(50) cname
   decimal(10,2) price
   int num
}
class cartitem {
   varchar(50) cname
   decimal(10,2) price
   int cquantity
   int id
}
class items {
   varchar(100) name
   decimal(50,2) price
   int quantity
   date import_date
   varchar(50) imported_by
}
class labour {
   varchar(50) name
   varchar(10) date_ofBirth
   varchar(50) email
   varchar(50) phone
   varchar(100) address
   varchar(50) position
   decimal(50,2) salary
   int labour_id
}
class menu {
   varchar(50) mname
   longblob image
   decimal(10,2) price
   varchar(50) kind
   int no
}
class tblorder {
   int quantity
   decimal(10,2) oprice
   date orderday
   varchar(50) staff
   int orderid
}
class users {
   varchar(20) name
   varchar(25) email
   varchar(25) phone
   varchar(50) username
   varchar(32) password
   varchar(100) position
   int no
}

cartitem  -->  cart : cname
menu  -->  cartitem : id:no
users  -->  items : imported_by:username
users  -->  tblorder : staff:username
