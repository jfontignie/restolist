import com.restolist.*

class BootStrap {

    def init = { servletContext ->
        if (!Country.count){
            new Country(name: "Suisse").save()
            new Country(name: "France").save()
        }

        if (!RestaurantType.count){
            new RestaurantType(type: "italien").save()
            new RestaurantType(type: "Chinois").save()
            new RestaurantType(type: "francais").save()
        }

        if (!Ingredient.count){
            new Ingredient(name: "Tomate").save()
            new Ingredient(name: "Jambon").save()
        }

        if (!Role.count){
            def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
            def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

            def testUser = new User(username: 'user', password: 'user').save()
            def adminUser = new User(username: "admin" ,password:"admin").save()

            UserRole.create(testUser,userRole,true)
            UserRole.create(adminUser,adminRole,true)
        }

        if (!Restaurant.count){
            def ch = Country.findAllByName("Suisse").get(0)
            def r = new Restaurant(name: "Le Corl",
                    address: new Address(street1: "27, route de Chancy",zipCode: "1213",city: "Petit-Lancy",country: ch),
            phoneNumber: "022.793.94.60").save()

            new Entry(name: "Rouleaux de Neims", price:12f,type: EntryType.APPETIZER,restaurant:r).save()
            new Entry(name: "Ribs de porc rôtis", price:13f,type: EntryType.APPETIZER,restaurant:r).save()
            new Entry(name: "Dim Sum", price:17f,type: EntryType.APPETIZER,restaurant:r).save()

            new Entry(name: "Porc Szetchuan sauté deux fois", price:27f,type: EntryType.MAIN,restaurant:r).save()
            new Entry(name: "Boeuf Szetchuan sauté deux fois", price:29f,type: EntryType.MAIN,restaurant:r).save()
            new Entry(name: "Boeuf à la sauce saté", price:29f,type: EntryType.MAIN,restaurant:r).save()
            new Entry(name: "Filet de boeuf au gingembre pimenté", price:29f,type: EntryType.MAIN,restaurant:r).save()
            new Entry(name: "Boeuf piquant sur lit de vermicelles frits", price:30f,type: EntryType.MAIN,restaurant:r).save()

            new Entry(name: "Beignets de banane, pomme, ananas", price:8.5,type: EntryType.DESERT,restaurant:r).save()
            new Entry(name: "Litchee au sirop", price:7f,type: EntryType.DESERT,restaurant:r).save()
            new Entry(name: "Gingembre config", price:7.5,type: EntryType.DESERT,restaurant:r).save()


        }
    }
    def destroy = {
    }
}
