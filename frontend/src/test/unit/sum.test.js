import sum from './sum'

describe ('unit test :: sum',() => {
    it(" adds two numbers and returns the total",()=>{
        //GIVEN
        const num1 = 12
        const num2 = 23

        //WHEN
        const actual = sum(num1,num2)

        //THEN
        expect(actual).toBe(35)
    })
})