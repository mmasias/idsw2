export default function coordinate() {
    let x = 0
    let y = 0
    let coodinate = { x, y }

    const setPosition = (x, y) => {
        coodinate.x = x
        coodinate.y = y
    }

    const getPosition = () => {
        return coodinate
    }

    return { setPosition, getPosition }
}
