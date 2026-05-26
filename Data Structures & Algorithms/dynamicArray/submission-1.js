class DynamicArray {

    constructor(capacity) {
        if (capacity > 0 ) {
            this.data = new Array();
            this.capacity = capacity;
        } else {
            console.log('INVALID CAPACITY');
        }
    }

    get(i) {
        return this.data[i];
    }

    set(i, n) {
        this.data[i] = n;
    }

    pushback(n) {
        let occupancy = this.getSize();
        let capacity = this.getCapacity();
        if (occupancy < capacity) {
            this.data.push(n);
        } else {
            this.resize();
            this.data.push(n);
        }
    }

    popback() {
        return this.data.pop();
    }

    resize() {
        this.capacity = this.capacity * 2;
    }

    getSize() {
        let count = 0;
        for (let item in this.data) {
            count ++;
        }
        return count;
    }

    getCapacity() {
        console.log('this.data:', this.data)
        return this.capacity;
    }
}
