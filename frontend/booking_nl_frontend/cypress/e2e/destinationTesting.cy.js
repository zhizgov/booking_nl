describe('log in and create destination as admin', () => {
//log in first
    beforeEach(() => {
      cy.visit('http://localhost:3000/login')
      
    })
  
    it('logs in with admin credentials', () => {
        cy.get('input[name=email]').type('ga@abv.bg')
      cy.get('input[name=password]').type('1234')
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click();
      cy.url().should('include', 'http://localhost:3000')
      cy.get('#createDest').click()   ;
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(1) > div').type('Aurora')
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(2)').type('Melbourne')
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > div:nth-child(3)').type('89.99')
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click()
    })
})

describe('log in and delete destination as admin', () => {
    //log in first
        beforeEach(() => {
          cy.visit('http://localhost:3000/login')
          
        })
      
        it('logs in with admin credentials', () => {
            cy.get('input[name=email]').type('ga@abv.bg')
      cy.get('input[name=password]').type('1234')
      cy.get('#root > div > div.MuiContainer-root.MuiContainer-maxWidthLg > div > form > button').click();
      cy.url().should('include', 'http://localhost:3000')
          cy.get('#root > div > div.container.text-center.py-5 > div > div:nth-child(2) > div > div > div > div.MuiGrid-root.MuiGrid-container.MuiGrid-item.MuiGrid-grid-xs-12.MuiGrid-grid-sm-true > div.MuiGrid-root.MuiGrid-container.MuiGrid-spacing-xs-2.MuiGrid-item.MuiGrid-direction-xs-column.MuiGrid-grid-xs-true > div:nth-child(2) > button').click()   ;
          cy.get('#deleteButon').click();
          cy.url().should('include', 'http://localhost:3000');
        })
    })