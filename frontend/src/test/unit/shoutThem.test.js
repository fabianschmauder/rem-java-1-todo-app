import {shoutThem} from "./shoutThem";

describe('unit test :: shoutThem',() => {
    it("returns an array with capital letters and two exclamation marks", () => {

        //GIVEN
        const myArray = ["hallo","bye"]

        //WHEN
        const actual = shoutThem(myArray)

        //THEN
        expect(actual).toEqual(["HALLO!!","BYE!!"])
    })
})