Based on
https://piotrminkowski.com/2020/07/31/an-advanced-guide-to-graphql-with-spring-boot/

GraphQL examples:
http://localhost:8080/graphiql

Department by id
{
department(id: 1) {
id
name
organization {
id
name
}
employees {
id
firstName
lastName
}
}
}

###############################

{
employeesWithFilter(filter: {
salary: {
operator: "gt",
value: "12000"
},
age: {
operator: "gt",
value: "30"
},
position: {
operator: "eq"
value: "Developer"
}
}) {
id
firstName
lastName
position
}
}

