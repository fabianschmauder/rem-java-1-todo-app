import {reverseString} from "./reverseString";

describe('unit test :: reverseString',() => {
    it(" returns reversed string",() =>{

        //GIVEN
        const string = "hello neuefische"

        //WHEN
        const actual = reverseString(string)

        //THEN
        expect(actual).toBe("ehcsifeuen olleh")
    })
})