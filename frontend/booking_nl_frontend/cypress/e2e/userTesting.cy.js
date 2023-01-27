describe("log in as admin", () => {
    //log in first
        beforeEach(() => {
          cy.visit('http://localhost:3000/login')
          
        })
      
        it('logs in with admin credentials', () => {
            cy.get('input[name=email]').type('ga@abv.bg')
      cy.get('input[name=password]').type('1234')
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click();
      cy.url().should('include', 'http://localhost:3000');
   }) })

   describe("log in as customer", () => {
    //log in first
        beforeEach(() => {
          cy.visit('http://localhost:3000/login')
          
        })
      
        it('logs in with admin credentials', () => {
            cy.get('input[name=email]').type('jaap@abv.bg')
      cy.get('input[name=password]').type('1234')
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click();
      cy.url().should('include', 'http://localhost:3000');
   }) })

   describe("register", () => {
    //log in first
        beforeEach(() => {
          cy.visit('http://localhost:3000/register')
          
        })
      
        it('register', () => {
            cy.get('input[name=fName]').type('Mimi')
            cy.get('input[name=lName]').type('Mem')
            cy.get('input[name=adress]').type('street')
            cy.get('input[name=email]').type('muki@abv.bg')
      cy.get('input[name=password]').type('1234')
      cy.get('#registerButton').click();
      cy.url().should('include', 'http://localhost:3000/login');
   }) })


   describe('update information', () => {
    //log in first
        beforeEach(() => {
          cy.visit('http://localhost:3000/login')
          
        })
      
        it('logs in with admin credentials', () => {
            cy.get('input[name=email]').type('mi@abv.bg')
          cy.get('input[name=password]').type('1234')
          cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click();
          cy.url().should('include', 'http://localhost:3000')
          cy.get('#root > div > div.makeStyles-root-1 > header > div > button.MuiButtonBase-root.MuiIconButton-root.makeStyles-menuButton-2.MuiIconButton-colorInherit.MuiIconButton-edgeStart').click()   ;
          cy.get('#outlined-basic').type('Milko')
          cy.get('#outlined-basic2').type('Mi')
          cy.get('#outlined-basic3').type('Mimi')
          cy.get('#root > div > div.userInfo > div > button').click()
          cy.url().should('include', 'http://localhost:3000/profile');
        })
    })