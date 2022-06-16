import Coordinate from './Coordinate.js'

export default function Obstacle () {
    const coordinate = Coordinate()
    const type = {
        1: '[#]',
        2: '[#]',
        3: '[#]',
    }

    function getObstacle() {
        return {
            posicion: getPosition(),
            type: type[getRandomArbitrary(1, 3)],
        }
    }

    function setPosition(x, y) {
        coordinate.setPosition(x, y)
    }

    function getPosition (){
        return coordinate.getPosition()
    }

    function getRandomArbitrary(min, max)  {
        return parseInt(Math.random() * (max - min) + min, 10)
    }

    return { getObstacle, setPosition, getPosition }
}