import Coordinate from './Coordinate.js'

export default function Item() {
    const coordinate = Coordinate()
    const typeItem = {
        1: '(*)',
        2: '(+)',
    }

    function getItem() {
        return {
            posicion: getPosition(),
            typeItem: typeItem[getRandomArbitrary(1, 3)],
        }
    }

    function setPosition (x, y) {
        coordinate.setPosition(x, y)
    }

    function getPosition (){
        return coordinate.getPosition()
    }

    function getRandomArbitrary (min, max) {
        return parseInt(Math.random() * (max - min) + min, 10)
    }

    return { getItem, setPosition, getPosition }
}
